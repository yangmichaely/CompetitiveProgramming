import React, { useEffect, useState } from 'react';
import {Link} from "react-router-dom";
const apiUrl = process.env.REACT_APP_API_BASE_URL;

function Solutions() {
  const [solutions, setSolutions] = useState([]);

  useEffect(() => {
    fetch(`${apiUrl}/api/solutions`)
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => setSolutions(data))
      .catch(error => console.error('There was a problem with the fetch operation:', error));
  }, []);

  return (
    <div>
      <h1>Competitive Programming Solutions</h1>
      <ul>
        {solutions.map((solution, index) => (
          <li key={index}>
            <Link to={`/solution/${solution.fileName}`}>
              {solution.fileName}
            </Link> - {new Date(solution.creationDate).toLocaleDateString()}
            {solution.isRecent && <span style={{ color: 'red' }}> - New</span>}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Solutions;
