import { Form, Button } from 'react-bootstrap'
import { useState } from "react"

function ObjTypeForm({handleNewObjtype}) {

    // State for the form
    const [nameValue, setNameValue] = useState('')
    const [descriptionValue, setDescriptionValue] = useState('')
    const [sizeValue, setSizeValue] = useState('')

    const nameInput = ({target:{value}}) => setNameValue(value)
    const descriptionInput = ({target:{value}}) => setDescriptionValue(value)
    const sizeInput = ({target:{value}}) => setSizeValue(value)

    const url = 'http://localhost:8080/types'

    // FORM SUBMIT
    function handleSubmit(e) {
        e.preventDefault()

        // Obj to send
        const newObjtype = {
            name: nameValue,
            description: descriptionValue,
            size: sizeValue
        }

        // POST request using fetch inside useEffect React hook
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newObjtype)
        };
        fetch(url + '/type', requestOptions)
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            handleNewObjtype(data)
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }

    return (
        <>
            <Form onSubmit={handleSubmit}>
                <Form.Control className="mb-3" type="text" onChange={nameInput} placeholder="Name" value={nameValue} />
                <Form.Control className="mb-3" type="text" onChange={descriptionInput} placeholder="Description" value={descriptionValue} />
                <Form.Control className="mb-3" type="text" onChange={sizeInput} placeholder="Size" value={sizeValue} />
                <Button variant="light" type="submit">Submit</Button>
            </Form>
        </>
    )
}

export default ObjTypeForm