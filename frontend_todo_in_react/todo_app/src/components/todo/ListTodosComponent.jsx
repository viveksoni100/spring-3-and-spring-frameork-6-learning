import {useEffect, useState} from "react";
import {retrieveTodosByUserApi} from "./api/TodoApiServicce";
import {deleteTodosByUserAndIdApi} from "./api/TodoApiServicce";

export default function ListTodosComponent() {

    const [todos, setTodos] = useState([]);
    const [msg, setMsg] = useState(null)

    useEffect(
        () => refreshTodos(), []
    );

    function refreshTodos() {
        retrieveTodosByUserApi('in28minutes')
            .then(response => setTodos(response.data))
            .catch(error => console.log(error))
    }

    function deleteTodo(id) {
        deleteTodosByUserAndIdApi('in28minutes', parseInt(id))
            .then(
                () => {
                    setMsg(`Delete of todos with id = ${id} successful`)
                    refreshTodos()
                }
            )
            .catch(error => console.log(error))
    }

    return (
        <div className="container">
            {msg && <div className="alert alert-success">{msg}</div>}
            <table className="table">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Is Done?</th>
                        <th>Target Date</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    {todos.map(todo => (
                        <tr key={todo.id}>
                            <td>{todo.description}</td>
                            <td>{todo.done.toString()}</td>
                            <td>{todo.targetDate}</td>
                            <td> <button className="btn btn-danger"
                                         onClick={() => deleteTodo(todo.id)}>Delete</button> </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}