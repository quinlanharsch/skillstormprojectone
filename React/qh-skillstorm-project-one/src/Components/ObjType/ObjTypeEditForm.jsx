import { Form, Button } from 'react-bootstrap'
import { useState } from "react"

function ObjTypeEditForm({editObjType, handleNewObjType}) {

    // State for the form
    const [nameValue, setNameValue] = useState(editObjType.name)
    const [descriptionValue, setDescriptionValue] = useState(editObjType.description)
    const [sizeValue, setSizeValue] = useState(editObjType.size)

    const nameInput = ({target:{value}}) => setNameValue(value)
    const descriptionInput = ({target:{value}}) => setDescriptionValue(value)
    const sizeInput = ({target:{value}}) => setSizeValue(value)

    const url = 'http://localhost:8080/types'

    // FORM SUBMIT
    function handleSubmit(e) {
        e.preventDefault()
        
        // Obj to send
        const newObjType = {
            objtypeid: editObjType.typid,
            name: nameValue,
            description: descriptionValue,
            size: sizeValue
        }

        fetch(url + '/type', { 
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newObjType)
        })
        .then(response => response.json())
        .then(data => {
            window.location.reload(false);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Control className="mb-3" type="text" onChange={nameInput} placeholder="Name" defaultValue={nameValue} />
            <Form.Control className="mb-3" type="text" onChange={descriptionInput} placeholder="Description" defaultValue={descriptionValue} />
            <Form.Control className="mb-3" type="text" onChange={sizeInput} placeholder="Size" defaultValue={sizeValue} />
            <Button variant="light" type="submit">Submit</Button>
        </Form>
    )
}

export default ObjTypeEditForm