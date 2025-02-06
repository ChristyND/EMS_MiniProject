db.createCollection('ems_project')

use ems_project

db.departments.insertOne({name:"Corporate",phone:"1-800-999-9999", budget: 1500000000})
db.departments.insertMany([{name:"Operations Management",phone:"1-800-888-8888", budget: 35000000},
{name:"Human Resources",phone:"1-800-777-7777", budget: 15000000},
{name:"Finance",phone:"1-800-567-1436", budget: 50000000},
{name:"Marketing",phone:"1-800-234-1543", budget: 50000000},
{name:"Information Technology",phone:"1-800-456-7890", budget: 35000000}
])

db.departments.find({})

db.employees.insertMany([{Name:{first:"John",last:"Doe"},DOE: '2001-02-06', dept:"Corporate"},
    {Name:{first:"Jane",last:"Doe"},DOE: '2001-02-06', dept:"Corporate"},
    {Name:{first:"Fred",last:"Dorse"},DOE: '2001-02-06', dept:"Operations Management"},
    {Name:{first:"Sarah",last:"McCoughlan"},DOE: '2001-02-06', dept:"Operations Management"},
    {Name:{first:"Darren",last:"Murphy"},DOE: '2001-02-06', dept:"Human Resources"},
    {Name:{first:"James",last:"Sunderland"},DOE: '2001-03-06', dept:"Finance"},
    {Name:{first:"Maria",last:"Sunderland"},DOE: '2001-03-06', dept:"Finance"},
    {Name:{first:"Angela",last:"Orosco"},DOE: '2001-03-06', dept:"Finance"},
    {Name:{first:"Eddie",last:"Dombrowski"},DOE: '2001-03-06', dept:"Information Technology"}
])