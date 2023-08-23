import React, { FormEvent, useState } from 'react';
import EditIcon from '@mui/icons-material/Edit';
import { useDispatch } from 'react-redux';

interface Props {
  id: string;
}

export default function MovieEdit(props: Props): JSX.Element {
  const { id } = props;
  const [title, setTitle] = useState<string>('');
  const [toggle, setToggle] = useState<boolean>(false);
  const dispatch = useDispatch();
  function handleEdit(event: FormEvent<HTMLFormElement>): void {
    event.preventDefault();
    dispatch({ type: 'movies/editTitle', payload: { id, newTitle: title } });
    setToggle(!toggle);
    setTitle('');
  }
  return (
    <div>
      <EditIcon onClick={() => { setToggle(!toggle); }} />
      {toggle &&
        (
          <form onSubmit={handleEdit}>
            <input type="text" placeholder="title" value={title} onChange={(e) => setTitle(e.target.value)} />
            <button type="submit">Сохранить</button>
          </form>
        )}
    </div>
  );
}
