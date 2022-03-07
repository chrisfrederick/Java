import logo from './logo.svg';
import './App.css';
import IndexComponent from './components/IndexComponent';

function App() {
  return (
    <div className="container">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>Music Archive</h1>\
        <IndexComponent/>
      </header>
    </div>
  );
}

export default App;
