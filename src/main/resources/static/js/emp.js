/**
 * Get without param
 */

$(document).ready(() => {
    /**
     * Get all
     */
    $('#show').click(() => {

        fetch(`/emp/ls`, {
            method: 'GET',
        }).then((response) => {
            response.json().then(data => {

                // Create a table element
                const table = document.querySelector('#tab1');
                table.setAttribute('border', '1');
                table.innerHTML = "";
                // <th>name</th>
                // <th>email</th>
                // <th>phone</th>
                table.innerHTML = `
                    <table>
                        <thead>
                            <tr>
                                ${Object.keys(data[0]).map(key => `<th>${key}</th>`).join('')}
                            </tr>
                        </thead>
                        <tbody>
                            ${data.map(obj => `
                                <tr>
                                    ${Object.values(obj).map(val => `<td>${val}</td>`).join('')}
                                </tr>
                            `).join('')}
                        </tbody>
                    </table>`;
                }
            )
        });
    })

    /**
     * Get with param
     */
    $('#sent-get').click(e => {
        e.preventDefault();
        const empId = $('#empId').val();
        fetch(`/emp/get-by-id?id=${empId}`, {
            method: 'GET',
        }).then((response) => {
            response.text().then(res => {
                $('#sent-get-p').text(`id ${empId}'s name is ${res}____`);
                $('#sent-get-p').css('text-decoration', 'underline');
            });
        });
    });

    /**
     * Post
     */
    $('#update').click( e => {

        e.preventDefault();
        const empID = $('#empId-u').val();
        const empName = $('#empName-u').val();
        const empPhone = $('#empPhone-u').val();

        fetch(`/emp/update`, {
            method: 'POST',
            body: JSON.stringify({
                employeeNo: empID,
                employeeName: empName,
                employeePhone: empPhone
            }),
            headers: {'Content-Type': 'application/json'},
        }).then(response => {
            response.text().then(res => {
                if (parseInt(res) > 0) {
                    alert(`update success`)
                } else {
                    alert(`update fail`)
                }
            })
        })
        ;
    });
    $('#time-submit-button').click(() => {
        const data = [];
        for (let i = 1; i < 8; i++) {
            const inputs = $(`#week-${i} input`);
            data.push({
                "openTimeNo": i,
                "week": i,
                "openTimeStart": inputs.eq(0).val() + ':00',
                "openTimeEnd": inputs.eq(1).val() + ':00'
            })
        }
        fetch('/rev/save-all',
            {
                method: 'POST',
                body: JSON.stringify(data),
                headers: {'Content-Type': 'application/json'},
            })
            .then(response => response.text())
            .then(ok => {
                if (ok){
                    swal.fire('儲存成功');
                }
            })
    })
})


function getOpenHour() {

}
