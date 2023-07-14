import Table from 'react-bootstrap/Table'
import { Pencil, Trash } from 'react-bootstrap-icons';
import Button from "react-bootstrap/Button"
import ButtonGroup from "react-bootstrap/ButtonGroup"
import { Modal } from 'react-bootstrap';
import { useState } from "react"
import ObjTypeEditForm from "./ObjTypeEditForm";

export default function ObjTypesTable({tableData}) {
    // Delete Button
    function handleDelete(typid) {
        fetch(`http://localhost:8080/types/type/${typid}`, {
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
    const [editObjType, setEditObjType] = useState({});
    
    return(
        <>
            <Table>
                <thead>
                    <tr>
                        {/* {
                            "typid": 3,
                            "name": "Gauze Pads",
                            "description": "Sterile pads made of cotton or other materials used to dress wounds and control bleeding.",
                            "size": 10,
                            "userlogged": "admin",
                            "calltime": "2023-07-14T05:21:16.336+00:00"
                        } */}
                        <th>Name</th>
                        <th>Description</th>
                        <th>Size</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {tableData.map((objtype) => {
                        return (
                            <tr key={objtype.typid}>
                                <td>{objtype.name}</td>
                                <td>{objtype.description}</td>
                                <td>{objtype.size}</td>
                                <td>
                                    <ButtonGroup aria-label="Action Buttons">
                                        <Button variant="light" size="sm" onClick={() => {setEditObjType(objtype); handleEditShow(); }}>
                                            <Pencil />
                                        </Button>
                                        <Button variant="light" size="sm" onClick={() => handleDelete(objtype.typid)}>
                                            <Trash />
                                        </Button>
                                    </ButtonGroup>
                                </td>
                            </tr>
                        )
                    }
                    )}
                </tbody>
            </Table>
            <Modal show={showEdit} onHide={handleEditClose} backdrop="static" keyboard={false}>
                <Modal.Header closeButton>
                    <Modal.Title>Edit Object Type</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <ObjTypeEditForm editObjType={editObjType} />
                </Modal.Body>
            </Modal>
        </>
    )
}
