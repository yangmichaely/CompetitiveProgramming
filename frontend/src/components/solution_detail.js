import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
const apiUrl = process.env.REACT_APP_API_BASE_URL;

function SolutionDetail() {
  const { fileName } = useParams();  // Get the fileName from the URL
  const [content, setContent] = useState('');
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch(`${apiUrl}/api/solution/${fileName}`)
      .then(response => {
        if (!response.ok) {
          // Handle non-2xx HTTP responses
          console.error('Server response:', response);
          throw new Error('Network response was not ok');
        }
        return response.json();  // Parse the JSON response
      })
      .then(data => setContent(data.content))
      .catch(error => {
        console.error('Error fetching file content:', error);
        setError('Could not load file content. Please try again later.');
      });
  }, [fileName]);

  if (error) {
    return <div>{error}</div>;
  }

  return (
    <div>
      <h1>Solution: {fileName}</h1>
      <pre>{content}</pre>
    </div>
  );
}

export default SolutionDetail;
