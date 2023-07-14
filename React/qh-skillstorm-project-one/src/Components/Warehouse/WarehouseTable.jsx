import Table from 'react-bootstrap/Table'
import { Pencil, Trash } from 'react-bootstrap-icons';
import Button from "react-bootstrap/Button"
import ButtonGroup from "react-bootstrap/ButtonGroup"
import { Modal } from 'react-bootstrap';
import { useState } from "react"
import WarehouseEditForm from "./WarehouseEditForm";
import handleNewWarehouse from "./WarehouseForm";

export default function WarehousesTable({tableData}) {
  // Delete Button
  function handleDelete(whsid) {
    fetch(`http://localhost:8080/warehouses/warehouse/${whsid}`, {
      method: 'DELETE'
    })
    .then(response => {
      if(response.ok) {
        window.location.reload(false);
      }else{
        throw new Error('Something went wrong');
      }
    })
    .then(data => {
      console.log('Success:', data);
    })
    .catch((error) => {
      console.error('Error:', error);
    });
  }

  const [showEdit, setEditShow] = useState(false);
  const handleEditClose = () => setEditShow(false);
  const handleEditShow = () => setEditShow(true);
  const [editWarehouse, setEditWarehouse] = useState({});

  return(
    <>
      <Table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Capacity</th>
            <th>HVAC</th>
            <th>Manager</th>
            <th>Address</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {tableData.map((warehouse) => {
            return (
              <tr key={warehouse.whsid}>
                <td>{warehouse.name}</td>
                <td>{warehouse.capacity}</td>
                <td>{warehouse.climatecontrolled?'Yes':'No'}</td>
                <td>{warehouse.manager}</td>
                <td>{warehouse.street1}{warehouse.street2?', ':'' + warehouse.street2}{' | ' + warehouse.city}{', ' + warehouse.state}{' '+warehouse.zip}{' ' + warehouse.country}</td>
                <td>
                  <ButtonGroup aria-label="Action Buttons">
                    <Button variant="light" size="sm" onClick={() => {setEditWarehouse(warehouse); handleEditShow(); }}>
                      <Pencil /> 
                    </Button>
                    <Button variant="light" size="sm" onClick={() => handleDelete(warehouse.whsid)}>
                      <Trash />
                    </Button>
                  </ButtonGroup>
                </td>
              </tr>
            );
          })}
        </tbody>
      </Table>

      <Modal show={showEdit} onHide={handleEditClose}>
        <Modal.Header closeButton>
          <Modal.Title>Edit Warehouse</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <WarehouseEditForm editWarehouse={editWarehouse} handleNewWarehouse={handleNewWarehouse} />
        </Modal.Body>
      </Modal>
    </>
  );
}