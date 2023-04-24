// kind of a class
const person = {
    name: 'Vivek Soni',
    address: {
        line1: 'Baker Street',
        city: 'London',
        country: 'UK'
    },
    // array
    profiles: ['twitter', 'linkedin', 'instagram'],
    // function
    printProfile: () => {
        person.profiles.map(
            (profile) => console.log(profile)
        )
    }
}

export default function LearningJavaScript() {
    return (
        <div>
            <div>{person.name}</div>
            <div>{person.address.line1}</div>
            <div>{person.profiles[1]}</div>
            <div>{person.printProfile()}</div>
        </div>
    )
}