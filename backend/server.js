const express = require('express');
const cors = require('cors');
const fs = require('fs');
const path = require('path');
const app = express();

app.use(cors());  // Enable CORS for all routes

const getFilesMetadata = (directoryPath) => {
  const files = fs.readdirSync(directoryPath);
  return files
    .filter(file => file.endsWith('.java'))
    .map(file => {
      const filePath = path.join(directoryPath, file);
      const stats = fs.statSync(filePath);
      return {
        fileName: file,
        creationDate: stats.birthtime,
        isRecent: (Date.now() - stats.birthtime.getTime()) < 7 * 24 * 60 * 60 * 1000 // Last 7 days
      };
    })
    .sort((a, b) => b.creationDate - a.creationDate);
};

app.get('/api/solutions', (req, res) => {
  const directoryPath = path.join(__dirname, 'answers');
  const fileMetadata = getFilesMetadata(directoryPath);
  res.json(fileMetadata);
});

// API endpoint to get the contents of a specific file
app.get('/api/solution/:fileName', (req, res) => {
  const fileName = req.params.fileName;
  const filePath = path.join(__dirname, 'answers', fileName);

  fs.readFile(filePath, 'utf8', (err, data) => {
    if (err) {
      return res.status(500).json({ error: 'File not found or could not be read.' });
    }
    res.json({ content: data });
  });
});


const PORT = process.env.PORT || 3001;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
