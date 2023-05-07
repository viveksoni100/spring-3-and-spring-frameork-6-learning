import {useParams} from "react-router-dom";
import {createTodoApi, retrieveTodoApi, updateTodoApi} from "./api/TodoApiServicce";
import {useAuth} from "./security/AuthContext";
import React, {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {useNavigate} from "react-router-dom";
import moment from "moment";

export default function TodoComponent() {

    const {id} = useParams();
    const authContext = useAuth();
    const username = authContext.username;
    const [desc, setDesc] = useState('');
    const [targetDate, setTargetDate] = useState(new Date());
    const navigate = useNavigate();

    /**
     * refresh only when the id value changes
     */
    useEffect(
        () => retrieveTodo(), [id]
    );

    function retrieveTodo() {
        if (id != -1) {
            retrieveTodoApi(username, id)
                .then(res => {
                    setDesc(res.data.description);
                    setTargetDate(res.data.targetDate);
                })
                .catch(err => console.log(err));
            console.log(id);
        }
    }

    /**
     *
     * @param updated values made available by formik
     */
    function onSubmit(values) {
        const todo = {
            id: id,
            username: username,
            description: values.desc,
            targetDate: values.targetDate,
            done: false
        };
        if (id == -1) {
            createTodoApi(username, todo)
                .then(res => {
                    navigate('/todos');
                })
                .catch(err => {
                    console.log(err);
                })
        } else {
            updateTodoApi(username, id, todo)
                .then(res => {
                    navigate('/todos');
                })
                .catch(err => console.log(err));
        }
    }

    function validate(values) {
        console.log(values);
        let err = {
            /*desc: 'enter a valid description',
            targetDate: 'enter a valid target date'*/
        };
        if (values.desc.length < 5) {
            err.desc = 'enter at least 5 characters';
        }
        if (values.targetDate == null || values.targetDate == '' || !moment(values.targetDate).isValid()) {
            err.targetDate = 'Enter a target date';
        }
        return err;
    }

    return (
        <div className="container">
            <h3>enter todo details</h3>
            <div>
                <Formik initialValues={{desc, targetDate}}
                        enableReinitialize={true}
                        validate={validate}
                        validateOnChange={false}
                        validateOnBlur={false}
                        onSubmit={onSubmit}>
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage
                                    name="desc"
                                    component="div"
                                    className="alert alert-danger"
                                />
                                <ErrorMessage
                                    name="targetDate"
                                    component="div"
                                    className="alert alert-danger"
                                />
                                <fieldset className="form-group">
                                    <label>Description</label>
                                    <Field type="text" className="form-control" name="desc"/>
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Target date</label>
                                    <Field type="date" className="form-control" name="targetDate"/>
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