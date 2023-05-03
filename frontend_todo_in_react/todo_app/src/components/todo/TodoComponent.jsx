import {useParams} from "react-router-dom";
import {retrieveTodoApi} from "./api/TodoApiServicce";
import {useAuth} from "./security/AuthContext";
import React, {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";

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

    function validate(values) {
        let err = {
            /*desc: 'enter a valid description',
            targetDate: 'enter a valid target date'*/
        };
        if(values.desc.length<5) {
            err.desc = 'enter at least 5 characters';
        }
        if(values.targetDate == null) {
            err.targetDate = 'Enter a target date';
        }
        console.log(values);
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