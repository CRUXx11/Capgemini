import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import * as ReactBootStrap from 'react-bootstrap';
import { Button,Form } from 'react-bootstrap';
function App() {
  const employees = [
    { name: "PK", job: "Developer" }
  ]

  const renderEmp = (employee, index) => {
    return (
      <tr key={index}>
        <td>{employee.name}</td>
        <td>{employee.job}</td>
        <td><Button variant="primary">Delete</Button></td>
        </tr>
        
    )
  }
  return (
    <div className="App">
      <ReactBootStrap.Table striped bordered hover>
        <thead>
          <tr>
            <th>Name</th>
            <th>Job</th>
            <th>Remove</th>
          </tr>
        </thead>
        <tbody>
            {employees.map(renderEmp)}
        </tbody>
      </ReactBootStrap.Table>
      <div>
        <Button variant="primary">Add Employere</Button></div>
    </div>
  );
}

export default App;
