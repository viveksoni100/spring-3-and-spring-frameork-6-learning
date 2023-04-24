import './App.css'
import { CounterButton } from './components/counter/Counter'

function App() {
  return (
    <div className="App">
      <CounterButton by={1}></CounterButton>
      <CounterButton by={2}></CounterButton>
      <CounterButton by={5}></CounterButton>
    </div>
  );
}

export default App;
