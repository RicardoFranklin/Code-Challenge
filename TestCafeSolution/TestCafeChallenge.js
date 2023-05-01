import { Selector } from 'testcafe';

fixture('Test Challenge')
    .page('http://localhost:3001/')


let devices;

test
    .before(async t => {
        devices = await t.request(`http://localhost:3000/devices`).body;
        // console.log(devices)
    })
    ('First Test', async t => {

        for (const device of devices) {

            console.log(device);

            const element = Selector('div.device-main-box')
                .withText(device.system_name)
                .withText(device.type)
                .withText(device.hdd_capacity);

            const editButton = Selector('div.device-main-box')
                .withText(device.system_name)
                .withText(device.type)
                .withText(device.hdd_capacity)
                .find('a.device-edit');


            const deleteButton = Selector('div.device-main-box')
                .withText(device.system_name)
                .withText(device.type)
                .withText(device.hdd_capacity)
                .find("button.device-remove");


            await t.expect(element.exists).ok();
            await t.expect(element.visible).ok();

            await t.expect(editButton.exists).ok();
            await t.expect(editButton.visible).ok();

            await t.expect(deleteButton.exists).ok();
            await t.expect(deleteButton.visible).ok();

        };

    });


test('Second Test', async t => {

    let capacity = parseInt(Math.random() * 999).toString();
    let fakeDevice = 'Fake Device';
    console.log("Numero: " + capacity);

    await t.click('a.submitButton')
        .typeText('input#system_name', fakeDevice)
        .typeText('input#hdd_capacity', capacity)
        .click('button.submitButton');

    await t.eval(() => location.reload(true));

    const element = Selector('div.device-main-box')
        .withText(fakeDevice)
        .withText(capacity);

    await t.expect(element.exists).ok();
    await t.expect(element.visible).ok();

});

test
    .before(async t => {
        devices = await t.request(`http://localhost:3000/devices`).body;
        // console.log(devices);

    })('Third Test', async t => {

        let device = devices[0];
        console.log(device);

        let deviceName = 'Renamed Device';

        let result = await t.request.put({
            url: `http://localhost:3000/devices/` + device.id,
            body: {
                system_name: deviceName,
                type: device.type,
                hdd_capacity: device.hdd_capacity
            }
        });

        console.log(result);

        await t.eval(() => location.reload(true));

        const element = Selector('div.device-main-box')
            .withText(deviceName)
            .withText(device.type)
            .withText(device.hdd_capacity);

        await t.expect(element.exists).ok();
        await t.expect(element.visible).ok();

    });



test
    .before(async t => {
        devices = await t.request(`http://localhost:3000/devices`).body;
        // console.log(devices);

    })('Fourth Test', async t => {

        let device = devices[devices.length - 1];
        console.log(device);

        let result = await t.request.delete({
            url: `http://localhost:3000/devices/` + device.id,
        });

        console.log(result);

        await t.eval(() => location.reload(true));

        const element = Selector('div.device-main-box')
            .withText(device.system_name)
            .withText(device.type)
            .withText(device.hdd_capacity);

        await t.expect(element.exists).notOk();
        await t.expect(element.visible).notOk();

    });