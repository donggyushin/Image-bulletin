<style media="screen">

    .postButton {
      background-color: #98999B;
      color: white;
      border-radius: 8px;
      font-size: 20px;
      padding: 5px;
      position: relative;
      left: 50px;
      top:30px;
    }

    .postButton > a {
      text-decoration: none;
      color: white;
    }


      .modalBox {
        background-color: #98999B;
        width: 404px;
        height: 180px;
        border-radius: 9px;
        position: fixed;
        top: 200px;
        left: 350px;
        -webkit-transition: opacity 400ms ease-in;
        -moz-transition: opacity 400ms ease-in;
        transition: opacity 400ms ease-in;
        overflow: auto;
        color: white;
        display: flex;
        flex-direction: column;
      }

      .modalBox__head {
        margin-top: 5px;
      }

      .modalBox__body {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
      }

      .modalBox__body__row {
        margin-top: 30px;
      }

      .modalBox__body__row__close {
        cursor: pointer;
      }

</style>
