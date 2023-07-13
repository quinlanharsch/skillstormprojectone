import WarehousesTable from "../Components/Warehouse/WarehouseTable"
import WarehousesForm from "../Components/Warehouse/WarehouseForm"
import { useState, useEffect } from "react"
import Modal from "react-bootstrap/Modal"

function Warehouses() {
  const url = 'http://localhost:8080/warehouses'
  // State for the table
  const [warehouses, addWarehouse] = useState([])
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  
  useEffect(() => {
    fetch(url)
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
      setWarehouses(data)
    })
    .catch((error) => {
      console.error('Error:', error);
    });
  }, [])

  function addWarehouse(warehouse) {
    setWarehouses((warehouses) => {[...warehouses, warehouse]})
  }

  return (
    <>
      <h1>Warehouses</h1>
      <Button variant="primary" onClick={handleShow}>
        Add Warehouse
      </Button>

      <WarehousesTable tableData={warehouses} />

      <Modal show={show} onHide={handleClose} backdrop="static" keyboard={false}>
        <Modal.Header closeButton>
          <Modal.Title>Add Warehouse Form</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <WarehousesForm addWarehouse={addWarehouse} />
        </Modal.Body>
      </Modal>
    </>
  )
}

export default Warehouses
