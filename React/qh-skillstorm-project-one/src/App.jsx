import MyNavbar from './Components/MyNavbar'
import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";import 'bootstrap/dist/css/bootstrap.min.css'
// import XXX from 'react-bootstrap/XXX

import Home from './Pages/Home'
import WhsObjects from './Pages/WhsObjects'
import Warehouses from './Pages/Warehouses'
import ObjTypes from './Pages/ObjTypes'

function App() {
  return (
    <>
      <MyNavbar />
      <br />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/warehouses" element={<Warehouses />} />
          <Route path="/whsobjects" element={<WhsObjects />} />
          <Route path="/objtypes" element={<ObjTypes />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
