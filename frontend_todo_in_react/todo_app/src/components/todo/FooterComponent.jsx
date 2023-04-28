import { useAuth } from "./security/AuthContext"

export default function FooterComponent() {

    const authContext = useAuth()
    console.log(`footer component - ${authContext.number}`)

    return (
        <footer className="footer">
            <div className="container">
                your footer
            </div>
        </footer>
    )
}