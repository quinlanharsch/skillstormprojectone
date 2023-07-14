import WarehousesTable from "../Components/Warehouse/WarehouseTable"
import WarehousesForm from "../Components/Warehouse/WarehouseForm"
import { useState, useEffect } from "react"
import Modal from "react-bootstrap/Modal"
import Button from "react-bootstrap/Button"
import { PlusCircle } from 'react-bootstrap-icons';


function Warehouses() {
  const url = 'http://localhost:8080/warehouses'
  
  // State for the table
  const [warehouses, setWarehouses] = useState([])
  
  // Modal state
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  
  // On Mount
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


  function handleNewWarehouse(warehouse) {
    window.location.reload(false); //TODO test false?
    // setWarehouses((warehouses) => {[...warehouses, warehouse]})
  }

  return (
    <>
      <h1>Warehouses</h1>
      <Button variant="light" onClick={handleShow}>
        <PlusCircle /> Add Warehouse
      </Button>

      <WarehousesTable tableData={warehouses} />

      {/* Form Modal */}
      <Modal show={show} onHide={handleClose} backdrop="static" keyboard={false}>
        <Modal.Header closeButton>
          <Modal.Title>Add Warehouse</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <WarehousesForm handleNewWarehouse={handleNewWarehouse} />
        </Modal.Body>
      </Modal>
    </>
  )
}

export default Warehouses
