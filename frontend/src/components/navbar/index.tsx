import { ReactComponent as GithubIcon } from 'assets/img/github.svg';

function Navbar() {
    return (
        <header>
        <nav>
          <div>
            <h1>DS Movie</h1>
            <a href="https://github.com/matheualan">
              <div>
                <GithubIcon />
                <p>/matheualan</p>
              </div>
            </a>
          </div>
        </nav>
        </header>
    );
}

export default Navbar;