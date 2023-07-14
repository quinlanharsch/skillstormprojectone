import Table from 'react-bootstrap/Table'
import { Pencil, Trash } from 'react-bootstrap-icons';
import Button from "react-bootstrap/Button"
import ButtonGroup from "react-bootstrap/ButtonGroup"
import { Modal } from 'react-bootstrap';
import { useState } from "react"
import WhsObjectEditForm from "./WhsObjectEditForm";

export default function WhsObjectTable({tableData}) {
    //Delete Button
    function handleDelete(whsid, typid) {
        fetch(`http://localhost:8080/objects/object/${whsid}/${typid}`, {
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
    const [editWhsObject, setEditWhsObject] = useState({});

    return(
        <>
            <Table>
                <thead>
                    <tr>
                        <th>Warehouse ID & Name</th>
                        <th>Object Type ID & Name</th>
                        <th>Quantity</th>
                        <th>Note</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {tableData.map((whsobject) => {
                        const key = `${whsobject.id.whsid}-${whsobject.id.typid}`;

                        return (
                        <tr key={key}>
                            <td>{whsobject.id.whsid} - {whsobject.warehouse.name}</td>
                            <td>{whsobject.id.typid} - {whsobject.objtype.name}</td>
                            <td>{whsobject.quantity}</td>
                            <td>{whsobject.note}</td>
                            <td>
                            <ButtonGroup aria-label="Action Buttons">
                                <Button variant="light" size="sm" onClick={() => {setEditWhsObject(whsobject); handleEditShow(); }}>
                                <Pencil />
                                </Button>
                                <Button variant="light" size="sm" onClick={() => handleDelete(whsobject.id.whsid, whsobject.id.typid)}>
                                <Trash />
                                </Button>
                            </ButtonGroup>
                            </td>
                        </tr>
                        );
                    })}
                </tbody>
            </Table>

            {/* Edit Modal */}
            <Modal show={showEdit} onHide={handleEditClose} backdrop="static" keyboard={false}>
                <Modal.Header closeButton>
                    <Modal.Title>Edit Wharehouse Object</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <WhsObjectEditForm editWhsObject={editWhsObject} />
                </Modal.Body>
            </Modal>
        </>
    )
}
