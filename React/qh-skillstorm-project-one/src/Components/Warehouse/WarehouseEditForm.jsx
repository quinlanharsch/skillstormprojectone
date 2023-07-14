import { Form, Button } from 'react-bootstrap'
import { useState } from "react"

function WarehouseEditForm({editWarehouse, handleNewWarehouse}) {
    
    // State for the form
    const [nameValue, setNameValue] = useState(editWarehouse.name)
    const [capacityValue, setCapacityValue] = useState(editWarehouse.capacity)
    const [climatecontrolledValue, setClimatecontrolledValue] = useState(editWarehouse.climatecontrolled)
    const [managerValue, setManagerValue] = useState(editWarehouse.manager)
    const [street1Value, setStreet1Value] = useState(editWarehouse.street1)
    const [street2Value, setStreet2Value] = useState(editWarehouse.street2)
    const [cityValue, setCityValue] = useState(editWarehouse.city)
    const [stateValue, setStateValue] = useState(editWarehouse.state)
    const [zipValue, setZipValue] = useState(editWarehouse.zip)
    const [countryValue, setCountryValue] = useState(editWarehouse.country)

    const nameInput = ({target:{value}}) => setNameValue(value)
    const capacityInput = ({target:{value}}) => setCapacityValue(value)
    const climatecontrolledInput = ({target:{value}}) => setClimatecontrolledValue(value)
    const managerInput = ({target:{value}}) => setManagerValue(value)
    const street1Input = ({target:{value}}) => setStreet1Value(value)
    const street2Input = ({target:{value}}) => setStreet2Value(value)
    const cityInput = ({target:{value}}) => setCityValue(value)
    const stateInput = ({target:{value}}) => setStateValue(value)
    const zipInput = ({target:{value}}) => setZipValue(value)
    const countryInput = ({target:{value}}) => setCountryValue(value)

    const url = 'http://localhost:8080/warehouses'
    
    // FORM SUBMIT
    function handleSubmit(e) {
        e.preventDefault()
        
        // Obj to send
        // const newWarehouse = {
        //     name: data.get('name'),
        //     capacity: data.get('capacity'),
        //     climatecontrolled: data.get('climatecontrolled'),
        //     manager: data.get('manager'),
        //     street1: data.get('street1'),
        //     street2: data.get('street2'),
        //     city: data.get('city'),
        //     state: data.get('state'),
        //     zip: data.get('zip'),
        //     country: data.get('country')
        //     // userlogged: "user",
        //     // calltime: new Date()
        // }

        // Obj to send
        const newWarehouse = {
            whsid: editWarehouse.whsid,
            name: nameValue,
            capacity: capacityValue,
            climatecontrolled: climatecontrolledValue,
            manager: managerValue,
            street1: street1Value,
            street2: street2Value,
            city: cityValue,
            state: stateValue,
            zip: zipValue,
            country: countryValue
            // userlogged: "user",
            // calltime: new Date()
        }

        console.log(JSON.stringify(newWarehouse)) // TODO: Remove this line

        fetch(url + '/warehouse', {
            method: 'PUT', // PURRRR
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newWarehouse)
        })
        .then(response => response.json())
        .then(data => {
            handleNewWarehouse(data)
            console.log('Success:', data);
            setNameValue('')
            setCapacityValue('')
            setClimatecontrolledValue('')
            setManagerValue('')
            setStreet1Value('')
            setStreet2Value('')
            setCityValue('')
            setStateValue('')
            setZipValue('')
            setCountryValue('')
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }
    
    return (
    <>
        <Form onSubmit={handleSubmit}>
            <Form.Control className="mb-3" type="text" onChange={nameInput} placeholder="Name" value={nameValue} />
            <Form.Control className="mb-3" type="number" onChange={capacityInput} placeholder="Capacity" value={capacityValue} />    
            <Form.Control className="mb-3" type="text" onChange={climatecontrolledInput} placeholder="Climate Controlled" value={climatecontrolledValue} />
            <Form.Control className="mb-3" type="text" onChange={managerInput} placeholder="Manager" value={managerValue} />
            <Form.Control className="mb-3" type="text" onChange={street1Input} placeholder="Street 1" value={street1Value} />
            <Form.Control className="mb-3" type="text" onChange={street2Input} placeholder="Street 2" value={street2Value} />
            <Form.Control className="mb-3" type="text" onChange={cityInput} placeholder="City" value={cityValue} />
            <Form.Control className="mb-3" type="text" onChange={stateInput} placeholder="State" value={stateValue} />
            <Form.Control className="mb-3" type="text" onChange={zipInput} placeholder="Zip" value={zipValue} />
            <Form.Control className="mb-3" type="text" onChange={countryInput} placeholder="Country" value={countryValue} />
            <Button variant="light" type="submit">
                Submit
            </Button>
        </Form>
    </>
    )
}

export default WarehouseEditForm