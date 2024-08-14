import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Solutions from './components/display_solutions';
import SolutionDetail from './components/solution_detail';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Solutions />} />
        <Route path="/solution/:fileName" element={<SolutionDetail />} />  {/* Routing to detail page */}
      </Routes>
    </Router>
  );
}

export default App;
