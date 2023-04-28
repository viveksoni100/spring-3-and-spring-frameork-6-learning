export default function ListTodosComponent() {

    const todos = [
        { id: 1, description: 'Learn AWS' },
        { id: 2, description: 'Learn Docker' },
        { id: 3, description: 'Learn gRPC' }
    ]

    return (
        <div className="container">
            <table className="table">
                <thead>
                    <tr>
                        <td>id</td>
                        <td>description</td>
                    </tr>
                </thead>
                <tbody>
                    {todos.map(todo => (
                        <tr key={todo.id}>
                            <td>{todo.id}</td>
                            <td>{todo.description}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}