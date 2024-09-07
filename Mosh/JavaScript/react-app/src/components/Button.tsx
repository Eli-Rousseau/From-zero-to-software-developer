import styles from "./Button.module.css";

interface Props {
  children: string;
  color?: "primary" | "secondary";
  onClick: () => void;
}

function Button({ children, onClick }: Props) {
  const handleClick = function () {
    onClick();
  };

  return (
    <button className={styles.btn} onClick={handleClick}>
      {children}
    </button>
  );
}

export default Button;
