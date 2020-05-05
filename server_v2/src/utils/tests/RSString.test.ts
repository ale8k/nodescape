import RSString from "../RSString";

test("Reads username/password from login stage", () => {
    const alexTest = [
        31, 223, 27,  97, 108,
       101, 120, 10, 116, 101,
       115, 116, 10
    ];
    const emptyUsernameTest = [
        31, 223,  27,  10,
       116, 101, 115, 116,
        10
    ];
    expect(RSString.readRSStringUsernameAndPassword(alexTest)).toStrictEqual(["alex", "test"]);
    expect(RSString.readRSStringUsernameAndPassword(emptyUsernameTest)).toStrictEqual(["", "test"]);
});

test("Encodes a string into correct Base37 encoding", () => {
    const alex123bytes = [
        0,  0,  0,  0,
      203, 41, 70, 61
    ];

    expect(RSString.writeStringToLongBytes37("Alex123")).toStrictEqual(alex123bytes);
});
