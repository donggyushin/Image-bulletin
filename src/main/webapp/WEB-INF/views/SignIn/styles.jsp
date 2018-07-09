<style media="screen">
    .container {
      width: 100%;
      display: flex;
      justify-content: space-around;
    }

    .container__inner {
      height: 500px;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      width: 40%;
    }

    .container__inner > span {
      font-family: 'Shrikhand', cursive;
      color: #98999B;
    }

    .container__inner__SigninForm {
      display: flex;
      flex-direction: column;
      width: 100%;
    }

    .container__inner__SigninForm__header {
      font-family: 'Shrikhand', cursive;
      font-size: 40px;
    }

    .container__inner__SigninForm > input {
      width: 80%;
      background-color: #CFD2D1;
      border: 0px;
      height: 30px;
      margin-top: 15px;
      border-radius: 9px;
    }

    .container__inner__SigninForm__button {

      color: white;
      font-size: 25px;
    }

    #container__inner__SigninForm__button {
      background-color: #74B4E8;
    }
  </style>