import React, { Component } from 'react'
import ReactTable from "react-table";


export class Table  extends Component{
    render() {
        const data = [{
            name: 'Charlie',
            job: 'Janitor'
           },{
            name: 'Mac',
            job:'Bouncer'
            },{
            name: 'Dee',
                job:'Aspiring actress'
            },{
            name: 'Dennis',
                job:'Bartender'
            }]
        const columns = [{
            Header: 'Name',
            accessor:'name'
        }, {
            Header: 'Job',
            accessor:'job'
        }
        ]
        
        return (
            <div>
                <ReactTable data={data} columns={columns}/>
            </div>
        )
    }
}

export default Table
