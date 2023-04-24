import { useState } from 'react'
import './Counter.css'
import { PropTypes } from 'prop-types'

export function Counter() {
    return (
        <dir>
            <CounterButton by={1}></CounterButton>
            <CounterButton by={2}></CounterButton>
            <CounterButton by={5}></CounterButton>
        </dir>
    )
}

export function CounterButton({by}) {

    // useState is a one of many hooks in react
    const [count, setCount] = useState(0);

    const countStyle = {
        fontSize: "120px",
        padding: "20px"
    };

    return (
        <div className="Counter">
            <span className="count"
                style={countStyle}>{count}</span>
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

CounterButton.propTypes = {
    by: PropTypes.number
}