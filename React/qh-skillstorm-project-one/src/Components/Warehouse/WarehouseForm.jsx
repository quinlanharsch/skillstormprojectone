import { Form, Button } from 'react-bootstrap'

function WarehouseForm({addWarehouse}) {
    
    const url = 'http://localhost:8080/warehouses'
    // TODO Make this GET method
         
    function handleSubmit(e) {
        e.preventDefault()
        
        const data = new FormData(e.target);
        
        const newWarehouse = {
            name: data.get('name'),
            capacity: data.get('capacity'),
            climatecontrolled: data.get('climatecontrolled'),
            street1: data.get('street1'),
            street2: data.get('street2'),
            city: data.get('city'),
            state: data.get('state'),
            zip: data.get('zip'),
            country: data.get('country'),
            userlogged: "user",
            calltime: new Date()
        }

        fetch(url + '/warehouse', { 
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newWarehouse)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            addWarehouse(data)
            e.target.reset()
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }
    
    return (
    <>
        <h1>Warehouse Form</h1>
        <Form onSubmit={handleSubmit}>
            <Form.Group>
                <Form.Label>Name</Form.Label>
                <Form.Control type="text" placeholder="Enter Name" value={warehouse.name} onChange={(e) => setWarehouse({...warehouse, name: e.target.value})} />
            </Form.Group>
            <Form.Group>
                <Form.Label>Capacity</Form.Label>
                <Form.Control type="number" placeholder="Enter Capacity" value={warehouse.capacity} onChange={(e) => setWarehouse({...warehouse, capacity: e.target.value})} />
            </Form.Group>
            <Form.Group>
                <Form.Label>Climate Controlled</Form.Label>
                <Form.Control type="text" placeholder="Enter Climate Controlled" value={warehouse.climatecontrolled} onChange={(e) => setWarehouse({...warehouse, climatecontrolled: e.target.value})} />
            </Form.Group>
            <Form.Group>
                <Form.Label>Street 1</Form.Label>
                <Form.Control type="text" placeholder="Enter Street 1" value={warehouse.street1} onChange={(e) => setWarehouse({...warehouse, street1: e.target.value})} />
            </Form.Group>
            <Form.Group>
                <Form.Label>Street 2</Form.Label>
                <Form.Control type="text" placeholder="Enter Street 2" value={warehouse.street2} onChange={(e) => setWarehouse({...warehouse, street2: e.target.value})} />
            </Form.Group>
            <Form.Group>
                <Form.Label>City</Form.Label>
                <Form.Control type="text" placeholder="Enter City" value={warehouse.city} onChange={(e) => setWarehouse({...warehouse, city: e.target.value})} />
            </Form.Group>
            <Form.Group>
                <Form.Label>State</Form.Label>
                <Form.Control type="text" placeholder="Enter State" value={warehouse.state} onChange={(e) => setWarehouse({...warehouse, state: e.target.value})} />
            </Form.Group>
            <Form.Group>
                <Form.Label>Zip</Form.Label>
                <Form.Control type="text" placeholder="Enter Zip" value={warehouse.zip} onChange={(e) => setWarehouse({...warehouse, zip: e.target.value})} />
            </Form.Group>
            <Form.Group>
                <Form.Label>Country</Form.Label>
                <Form.Control type="text" placeholder="Enter Country" value={warehouse.country} onChange={(e) => setWarehouse({...warehouse, country: e.target.value})} />
            </Form.Group>
            <Button variant="primary" type="submit">
                Submit
            </Button>
        </Form>
    </>
    )
}
