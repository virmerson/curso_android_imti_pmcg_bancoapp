package com.htcursos.sprinklesapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.htcursos.sprinklesapp.R;
import com.htcursos.sprinklesapp.models.User;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Virmerson on 31/07/15.
 */
public class UsersListAdapter extends ArrayAdapter<User>{

    public List<User> users;

    public UsersListAdapter(Context context, List<User> users) {
        super(context, R.layout.item_user, users);
        this.users = users;
    }

    /**
     * @param position
     * @param convertView  (Item)
     * @param parent (ListView)
     * @return
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final  ViewHolder holder;
        //Se o item não existe então faz o inflate (Reaproveitamento de Views)
        if(convertView == null) {
            //Inflando o Layout
            convertView = View.inflate(getContext(), R.layout.item_user, null);

            //Instanciando o Holder
            holder = new ViewHolder();
            //Fazendo o Bind do Holder com a View Item
            ButterKnife.bind(holder, convertView);

            //Setando uma Tag para poder recuperar depois
            convertView.setTag(holder);
        } else {
            //Carregando um holder de uma view já existente
            holder = (ViewHolder) convertView.getTag();
        }

        //Acessando o usuario da list para inserir na View

        final User user = users.get(position);
        //Carregando dados do usuario no Holder
        if(user!=null) {
            holder.userName.setText(user.name);
        }
        return convertView;
    }
    //Local onde guardamos as views (todas as referencias)
   public class ViewHolder{

        @Bind(R.id.item_user_name)
        TextView userName;

    }
}