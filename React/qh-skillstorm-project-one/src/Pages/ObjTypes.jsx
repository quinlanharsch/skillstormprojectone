import ObjTypesTable from "../Components/ObjType/ObjTypeTable"
import ObjTypesForm from "../Components/ObjType/ObjTypeForm"
import { useState, useEffect } from "react"
import Modal from "react-bootstrap/Modal"
import Button from "react-bootstrap/Button"
import { PlusCircle } from 'react-bootstrap-icons';

function ObjTypes() {
  const url = 'http://localhost:8080/types'
  
  // State for the table
  const [objtypes, setObjtypes] = useState([])

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
      setObjtypes(data)
    })
    .catch((error) => {
      console.error('Error:', error);
    });
  }, [])

  return (
    <>
      <h1>Object Types</h1>
      <Button variant="light" onClick={handleShow}>
        <PlusCircle /> Add Object Type
      </Button>

      <ObjTypesTable tableData={objtypes} />

      {/* Form Modal */}
      <Modal show={show} onHide={handleClose} backdrop="static" keyboard={false}>
        <Modal.Header closeButton>
          <Modal.Title>Add Object Type</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <ObjTypesForm />
        </Modal.Body>
      </Modal>
    </>
  )
}

export default ObjTypes
