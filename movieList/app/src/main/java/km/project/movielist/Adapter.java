package km.project.movielist;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private int layoutId;

    private List<String> items;

    public Adapter(Context context, int layoutId) {
        this.context = context;
        this.layoutId = layoutId;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String item = items.get(position);
        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).textView.setText(item);
        }

    }

    @Override
    public int getItemCount() {
        return items \== null ? 0 : items.size();
    }

    public void addItem(List<String> item) {
        if (items \== null)
        items \= new ArrayList<>();
        items.addAll(item);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView \= itemView.findViewById(R.id.txtTitle);
        }
    }
}
