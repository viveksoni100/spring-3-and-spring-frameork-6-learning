import {useParams} from "react-router-dom";
import {retrieveTodoApi} from "./api/TodoApiServicce";
import {useAuth} from "./security/AuthContext";
import {useEffect, useState} from "react";
import {Field, Form, Formik} from "formik";

export default function TodoComponent() {

    const {id} = useParams();
    const authContext = useAuth();
    const username = authContext.username;
    const [desc, setDesc] = useState('');
    const [targetDate, setTargetDate] = useState(new Date());

    /**
     * refresh only when the id value changes
     */
    useEffect(
        () => retrieveTodo(), [id]
    );

    function retrieveTodo() {
        retrieveTodoApi(username, id)
            .then(res => {
                setDesc(res.data.description);
                setTargetDate(res.data.targetDate);
            })
            .catch(err => console.log(err));
    }

    /**
     *
     * @param updated values made available by formik
     */
    function onSubmit(values) {
        console.log(values);
    }

    return (
        <div className="container">
            <h3>enter todo details</h3>
            <div>
                <Formik initialValues={{desc, targetDate}}
                    enableReinitialize={true}
                    onSubmit={onSubmit}>
                    {
                        (props) => (
                            <Form>
                                <fieldset className="form-group">
                                    <label>Description</label>
                                    <Field type="text" classname="form-control" name="desc"/>
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Target date</label>
                                    <Field type="date" classname="form-control" name="targetDate"/>
                                </fieldset>
                                <div>
                                    <button className="btn btn-success" type="submit">save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}