import genres from '../data/genres';

export interface Genre {
    id: number;
    name: string;
    image_background: string;
}

const useGenres = function() {
  return ({data: genres, isLoading: false, error: null});
};

export default useGenres;