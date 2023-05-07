import {useEffect, useState} from "react";
import {retrieveTodosByUserApi} from "./api/TodoApiServicce";
import {deleteTodosByUserAndIdApi} from "./api/TodoApiServicce";
import {useAuth} from "./security/AuthContext";
import {useNavigate} from "react-router";

export default function ListTodosComponent() {

    const [todos, setTodos] = useState([]);
    const [msg, setMsg] = useState(null);
    const authContext = useAuth();
    const username = authContext.username;
    const navigate = useNavigate();

    useEffect(
        () => refreshTodos(), []
    );

    function refreshTodos() {
        retrieveTodosByUserApi(username)
            .then(response => setTodos(response.data))
            .catch(error => console.log(error))
    }

    function deleteTodo(id) {
        deleteTodosByUserAndIdApi(username, parseInt(id))
            .then(
                () => {
                    setMsg(`Delete of todos with id = ${id} successful`);
                    refreshTodos()
                }
            )
            .catch(error => console.log(error))
    }

    function updateTodo(id) {
        navigate(`/todo/${id}`);
    }

    function addNewTodo() {
        navigate('/todo/-1');
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
                        <th>Update</th>
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
                            <td> <button className="btn btn-success"
                                         onClick={() => updateTodo(todo.id)}>Update</button> </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div className="btn btn-success m-3" onClick={addNewTodo}>Add New Todo</div>
        </div>
    )
}