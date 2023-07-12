import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

import { HeartPulseFill, House, Book, Building, Box2 } from 'react-bootstrap-icons';

import './MyNavbar.css'

function MyNavbar() {
  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary-tertiary sticky-nav">
        <Container>
          <Navbar.Brand href="/"><HeartPulseFill /> FreeHouse</Navbar.Brand>
          <Nav.Link href="/"><House /> Home</Nav.Link>
          <Nav.Link href="/warehouses"><Building /> Warehouses</Nav.Link>
          <Nav.Link href="/whsobjects"><Box2 /> Inventory</Nav.Link>
          <Nav.Link href="/objtypes"><Book /> Catalog</Nav.Link>
        </Container>
      </Navbar>
    </>
  )
}

export default MyNavbar
