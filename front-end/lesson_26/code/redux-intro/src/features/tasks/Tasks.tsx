import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
// eslint-disable-next-line import/no-extraneous-dependencies
import DeleteIcon from '@mui/icons-material/Delete';
// eslint-disable-next-line import/no-extraneous-dependencies
import CheckBoxIcon from '@mui/icons-material/CheckBox';
// eslint-disable-next-line import/no-extraneous-dependencies
import CheckBoxOutlineBlankIcon from '@mui/icons-material/CheckBoxOutlineBlank';
import { RootState } from '../../store';

export default function Tasks(): JSX.Element {
  const tasks = useSelector((state: RootState) => state.tasks);
  const dispatch = useDispatch();

  function handleChangeStatus(id: string): void {
    dispatch({ type: 'tasks/changeStatus', payload: id });
  }

  function handleRemove(id: string): void {
    dispatch({ type: 'tasks/remove', payload: id });
  }

  return (
    <div>
      <h1>Tasks</h1>
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            <span style={
              task.isDone ? { textDecoration: 'line-through' } : { textDecoration: 'none' }
            }
            >
              <b>{task.title}</b> {task.description}
            </span>
            <DeleteIcon onClick={() => handleRemove(task.id)} />
            {
              task.isDone ?
                <CheckBoxIcon onClick={() => handleChangeStatus(task.id)} /> :
                <CheckBoxOutlineBlankIcon onClick={() => handleChangeStatus(task.id)} />
            }
          </li>
        ))}
      </ul>
    </div>
  );
}
