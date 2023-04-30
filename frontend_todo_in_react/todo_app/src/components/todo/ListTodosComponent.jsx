import {useEffect, useState} from "react";
import {retrieveTodosByUser} from "./api/TodoApiServicce";

export default function ListTodosComponent() {

    /*const todosOld = [
        { id: 1, description: 'Learn AWS' },
        { id: 2, description: 'Learn Docker' },
        { id: 3, description: 'Learn gRPC' }
    ];*/

    const [todos, setTodos] = useState([]);

    useEffect(
        () => refreshTodos(), []
    );

    function refreshTodos() {
        retrieveTodosByUser('in28minutes')
            .then(response => setTodos(response.data))
            .catch(error => console.log(error))
    }

    return (
        <div className="container">
            <table className="table">
                <thead>
                    <tr>
                        <td>id</td>
                        <td>description</td>
                        <td>is_done</td>
                        <td>target_date</td>
                    </tr>
                </thead>
                <tbody>
                    {todos.map(todo => (
                        <tr key={todo.id}>
                            <td>{todo.id}</td>
                            <td>{todo.description}</td>
                            <td>{todo.done.toString()}</td>
                            <td>{todo.targetDate}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}