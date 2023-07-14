import { Form, Button } from 'react-bootstrap'
import { useState } from "react"

function WhsObjectForm() {

    // State for the form
    const [whsidValue, setWhsidValue] = useState('')
    const [typidValue, setTypidValue] = useState('')
    const [quantityValue, setQuantityValue] = useState('')
    const [noteValue, setNoteValue] = useState('')

    const whsidInput = ({target:{value}}) => setWhsidValue(value)
    const typidInput = ({target:{value}}) => setTypidValue(value)
    const quantityInput = ({target:{value}}) => setQuantityValue(value)
    const noteInput = ({target:{value}}) => setNoteValue(value)

    const url = 'http://localhost:8080/objects'

    // FORM SUBMIT
    function handleSubmit(e) {
        e.preventDefault()

        // Obj to send
        const newWhsObject = {
            id: {
                whsid: whsidValue,
                typid: typidValue
            },
            quantity: quantityValue,
            note: noteValue
        }

        fetch(url + '/object', { 
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newWhsObject)
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
            <Form.Control className="mb-3" type="number" placeholder="Warehouse ID" value={whsidValue} onChange={whsidInput} />
            <Form.Control className="mb-3" type="number" placeholder="Object Type ID" value={typidValue} onChange={typidInput} />
            <Form.Control className="mb-3" type="number" placeholder="Quantity" value={quantityValue} onChange={quantityInput} />
            <Form.Control className="mb-3" type="text" placeholder="Note" value={noteValue} onChange={noteInput} />
            <Button variant="light" type="submit">Submit</Button>
        </Form>
    )
}

export default WhsObjectForm