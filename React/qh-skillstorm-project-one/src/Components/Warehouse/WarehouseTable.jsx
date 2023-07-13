import { Table } from 'react-bootstrap/Table'

function WarehousesTable({tableData}) {
  return(
      <>
        <Table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Capacity</th>
              <th>Climate Controlled</th>
              <th>Address</th>
            </tr>
          </thead>
          <tbody>
            {tableData.map((warehouse) => {
              return (
                <tr key={warehouse.id}> {/** need to set the key so react knows which elemetns in the DOM to modify*/}
                  <td>{warehouse.whsid}</td>
                  <td>{warehouse.name}</td>
                  <td>{warehouse.capacity}</td>
                  <td>{warehouse.climatecontrolled}</td>
                  <td>{warehouse.street1 + warehouse.street2?', ':''
                  + warehouse.street2 + ', '
                  + warehouse.city + ', '
                  + warehouse.state + ' '
                  + warehouse.zip + ', '
                  + warehouse.country
                  }</td>
                </tr>
              );
            })}
          </tbody>
        </Table>
      </>
  );
}

export default WarehousesTable