import axios from "axios";
import "./App.css";

const getTestData = () => {
  axios.get("/testTable/all").then((res) => {
    console.log(res);
  });
};

function App() {
  getTestData();

  return (
    <div className="App">
      <header className="App-header">his</header>
    </div>
  );
}

export default App;
