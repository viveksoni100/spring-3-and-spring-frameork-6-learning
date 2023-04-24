import { useState } from 'react'
import './Counter.css'

export function Counter() {

    // useState is a one of many hooks in react
    const [count, setCount] = useState(0);

    const countStyle = {
        fontSize: "120px",
        padding: "20px"
    };

    return (
        <dir>
            <span className="count"
                style={countStyle}>{count}</span>
            <CounterButton by={1}></CounterButton>
            <CounterButton by={2}></CounterButton>
            <CounterButton by={5}></CounterButton>
        </dir>
    )

    function CounterButton({by}) {

        return (
            <div className="Counter">
                <button className="counterButton"
                    onClick={incrementCounterFunction}>+{by}</button>
                <button className="counterButton"
                    onClick={decrementCounterFunction}>-{by}</button>
            </div>
        )
    
        function incrementCounterFunction() {
            setCount(count + by)
            console.log(count)
            console.log('increment clicked')
        }
    
        function decrementCounterFunction() {
            setCount(count - by)
            console.log(count)
            console.log('decrement clicked')
        }
    }
}