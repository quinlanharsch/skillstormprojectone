import { Form, Button } from 'react-bootstrap';
import { useState } from "react";

function WhsObjectEditForm({ editWhsObject }) {
    const [whsidValue, setWhsidValue] = useState(editWhsObject.id.whsid);
    const [typidValue, setTypidValue] = useState(editWhsObject.id.typid);
    const [quantityValue, setQuantityValue] = useState(editWhsObject.quantity);
    const [noteValue, setNoteValue] = useState(editWhsObject.note);

    const whsidInput = (e) => setWhsidValue(e.target.value);
    const typidInput = (e) => setTypidValue(e.target.value);
    const quantityInput = (e) => setQuantityValue(e.target.value);
    const noteInput = (e) => setNoteValue(e.target.value);

    const url = 'http://localhost:8080/objects';

    function handleSubmit(e) {
        e.preventDefault();

        const newWhsObject = {
            id: {
                whsid: whsidValue,
                typid: typidValue
            },
            quantity: quantityValue,
            note: noteValue
        };

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
            <Form.Control className="mb-3" type="number" onChange={whsidInput} placeholder="Warehouse ID" value={whsidValue}  />
            <Form.Control className="mb-3" type="number" onChange={typidInput} placeholder="Object Type ID" value={typidValue} />
            <Form.Control className="mb-3" type="number" onChange={quantityInput} placeholder="Quantity" value={quantityValue}  />
            <Form.Control className="mb-3" type="text" onChange={noteInput} placeholder="Note" value={noteValue}  />
            <Button variant="light" type="submit">Submit</Button>
        </Form>
    );
}

export default WhsObjectEditForm;