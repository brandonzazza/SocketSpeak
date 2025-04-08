import React, {useState} from 'react';
import styles from './Login.module.css';

function AppLogin() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    function handelUsernameChange(e){
      setUsername(e.target.value);
    }

    function handelPasswordChange(e){
      setPassword(e.target.value);
    }

    function handelGetLogin(event) {
      event.preventDefault();
      console.log('Username:', username);
      console.log('Password:', password);
    }

    return (
      <div className={styles.outer_login_window}>
        <div className={styles.inner_login_window}>
            <h1 className={styles.login_title}>Login</h1>
            <form onSubmit={handelGetLogin}>
                <h2>Username</h2>
                <input className={styles.input} value={username} placeholder='username' onChange={handelUsernameChange}></input>
                <h2>Password</h2>
                <input className={styles.input} value={password} placeholder='password'onChange={handelPasswordChange}></input>
                <button type="submit" className={styles.button}>Login</button>
            </form>
        </div>
      </div>
    );
  }
  
export default AppLogin
  