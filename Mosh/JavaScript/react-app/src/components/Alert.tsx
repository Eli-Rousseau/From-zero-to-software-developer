interface Props {
  children: string;
  onClick: () => void;
}

function Alert({ children, onClick }: Props) {
  const handleClick = function () {
    onClick();
  };
  return (
    <div className="alert alert-primary alert-dismissible">
      {children}
      <button
        type="button"
        className="close"
        data-dismiss="alert"
        aria-label="Close"
        onClick={handleClick}
      >
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
  );
}

export default Alert;
