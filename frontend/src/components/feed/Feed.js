import React, { useEffect, useState } from 'react';
import Fetch from '../fetch/Fetch';
import { useDispatch, useSelector } from 'react-redux';
import OneMeme from './OneMeme';

const Feed = () => {
  const dispatch = useDispatch();

  const memeList = useSelector(state => state.memeReducer.memeList);
  const errormessage = useSelector(state => state.memeReducer.FeedErrormessage);
  const feedState = useSelector(state => state.memeReducer.FeedState);

  useEffect(() => {
    /*Fetch('GET', '/meme')
      .then(response => {})
      .catch(error => dispatch({ type: 'FEED_ERROR', error: error }));*/
    dispatch({ type: 'FILL_MEME_LIST', memeList: memeList });
  }, [feedState]);

  if (errormessage) {
    return <div>{errormessage}</div>;
  } else {
    return <div>{memeList.map(meme => OneMeme(meme))}</div>;
  }
};

export default Feed;
