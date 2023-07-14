import freehouse from '../assets/FreedomHouse.png';

function Home() {
  return (
    <>
      <h1>Home</h1>
      <p>Welcome. Please navigate with the tabs above.</p>
      <img src={freehouse} className="img-fluid" alt="Freedom House" />
      <p>Image ripped from WQED</p>
    </>
  )
}

export default Home
