const { it, expect } = require('@jest/globals');
const request = require('supertest');

it('save patient', (done) => {
    request('http://localhost:7002/')
        .post('patient/')
        .send({ id: 1, name: 'android', dob: new Date(), address: 'pune' })
        .expect(200)
        .then(res => {
            expect(res.body.body.name).toBe('android')
            done()
        })
})

it('Getting List Of Patients', (done) => {
    request('http://localhost:7002/')
        .get('patient/')
        .expect(200)
        .then(res => {
            expect(res.body.length).toBeGreaterThan(0)
            done()
        })
})

it('Generate Bill For Patient', (done) => {
    request('http://localhost:7002/')
        .post('patient/car/bill')
        .send({ id: 1, billDate: new Date(), customerName: 'androd' })
        .then(res => {
            done()
        })
})

it('Save Supplier', (done) => {
    request('http://localhost:6002/')
        .post('supplier/')
        .send({ id: 1, name: 'Android' })
        .then(res => {
            console.log(res.body)
            done()
        })
})

it('Save Conractor 1', (done) => {
    request('http://localhost:6002/')
        .post('contract/')
        .send({
            id: 1,
            name: 'Contrcat 1',
            status: 'active',
            supplier: {
                id: 1, name: 'Android'
            }
        })
        .then(res => {
            console.log(res.body)
            done()
        })
})


