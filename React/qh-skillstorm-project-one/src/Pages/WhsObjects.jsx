import WhsObjectsTable from "../Components/WhsObject/WhsObjectTable"
import WhsObjectsForm from "../Components/WhsObject/WhsObjectForm"
import { useState, useEffect } from "react"
import Modal from "react-bootstrap/Modal"
import Button from "react-bootstrap/Button"
import { PlusCircle } from 'react-bootstrap-icons';

function WhsObjects() {
  const url = 'http://localhost:8080/objects'

  // State for the table
  const [whsobjects, setWhsObjects] = useState([])

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
      setWhsObjects(data)
    })
    .catch((error) => {
      console.error('Error:', error);
    });
  }, [])

  return (
    <>
      <h1>Warehouse Objects</h1>
      <Button variant="light" onClick={handleShow}>
        <PlusCircle /> Add Wharehouse Object
      </Button>

      <WhsObjectsTable tableData={whsobjects} />

      {/* Form Modal */}
      <Modal show={show} onHide={handleClose} backdrop="static" keyboard={false}>
        <Modal.Header closeButton>
          <Modal.Title>Add Wharehouse Object</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <WhsObjectsForm />
        </Modal.Body>
      </Modal>
    </>
  )
}

export default WhsObjects