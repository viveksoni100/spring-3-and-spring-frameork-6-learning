import './Counter.css'
import CounterButton from './CounterButton';
import { useState } from 'react'

export default function Counter() {

    // useState is a one of many hooks in react
    const [count, setCount] = useState(0);

    function incrementCounterFunction(by) {
        setCount(count + by)
    }

    function decrementCounterFunction(by) {
        setCount(count - by)
    }

    function resetCounter() {
        setCount(0)
    }

    const countStyle = {
        fontSize: "120px",
        padding: "20px"
    };

    return (
        <dir>
            <span className="count"
                style={countStyle}>{count}</span>
            <CounterButton by={1} increment={incrementCounterFunction} decrement={decrementCounterFunction}></CounterButton>
            <CounterButton by={2} increment={incrementCounterFunction} decrement={decrementCounterFunction}></CounterButton>
            <CounterButton by={5} increment={incrementCounterFunction} decrement={decrementCounterFunction}></CounterButton>
            <button className="resetButton" onClick={resetCounter}>Reset</button>
        </dir>
    )
}